package co.kommit.gtm;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.TiContext;
import org.appcelerator.titanium.util.TiRHelper;
import org.appcelerator.titanium.util.TiRHelper.ResourceNotFoundException;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;

import com.google.android.gms.tagmanager.Container;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.TagManager;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.sun.xml.internal.xsom.impl.scd.Iterators.Map;

@Kroll.module(name = "Gtm", id = "co.kommit.gtm")
public class GtmModule extends KrollModule {

    private static final String LCAT = "GtmModule";

    private static final long TIMEOUT_FOR_CONTAINER_OPEN_MILLISECONDS = 2000;
    
    @Kroll.constant public static final Object OBJECT_NOT_PRESENT = DataLayer.OBJECT_NOT_PRESENT;

    public GtmModule() {
        super();

    }

    private Context context() {
        return TiContext.getCurrentTiContext().getAndroidContext();
    }

    private DataLayer dataLayer() {
        return TagManager.getInstance(context()).getDataLayer();
    }
    
    private Container container() {
    	return ContainerHolderSingleton.getContainerHolder().getContainer();
    }

    private int R(String path) {
        int result = 0;
        Log.d(LCAT, "Resource id for " + path);

        try {
            result = TiRHelper.getAndroidResource(path);
        } catch (ResourceNotFoundException e) {
            Log.d(LCAT, "Resource not found " + path);
        }

        return result;
    }

    @Kroll.onAppCreate
    public static void onAppCreate(TiApplication app) {
        Log.d(LCAT, "inside onAppCreate");
    }

    @Kroll.method
    public void openScreenEvent(String screenName) {
        Utils.pushOpenScreenEvent(context(), screenName);
    }

    @Kroll.method
    public void closeScreenEvent(String screenName) {
        Utils.pushCloseScreenEvent(context(), screenName);
    }

    @Kroll.method
    public void clickEvent(String key, String buttonName) {
    	Log.d(LCAT, "clickEvent");
        dataLayer().push(DataLayer.mapOf("event", "click", "buttonName", buttonName));
    }
    
    @Kroll.method
    public void pushObject(KrollDict obj) {
        dataLayer().push(obj);
    }
    
    
    @Kroll.method
    public void pushKeyValue(String key, Object obj) {
        dataLayer().push(key, obj);
    }
    
    @Kroll.method
    public KrollDict mapOf(Object[] objects) {
    	java.util.Map<String, Object> obj = null;
    	try {
    		obj = DataLayer.mapOf(objects);
    		JSONObject json = new JSONObject(obj);
    		return new KrollDict(json);
    	} catch (Exception e) {
    		
    	}
    	return null;
    }
    
    @Kroll.method
    public Object[] listOf(Object[] objects) {
    	Object[] list = DataLayer.listOf(objects).toArray();
    	return list;
    }
    
    @Kroll.method
    public String getString(String key) {
        return container().getString(key);
    }

    @Kroll.method
    public boolean getBoolean(String key) {
        return container().getBoolean(key);
    }

    @Kroll.method
    public double getDouble(String key) {
        return container().getDouble(key);
    }

    @Kroll.method
    public long getLong(String key) {
        return container().getLong(key);
    }

    @Kroll.method
    public long getLastRefreshtTime() {
        return container().getLastRefreshTime();
    }

    @Kroll.method
    public void init(String containerId) {
        Log.d(LCAT, "Loading container ID: " + containerId);
	    try {
	    	int v = context().getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
	    	Log.d(LCAT, "Using google play services version " + v);
	    } catch (NameNotFoundException nnfe) {}

        TagManager tagManager = TagManager.getInstance(this.getActivity());
        tagManager.setVerboseLoggingEnabled(true);


        PendingResult<ContainerHolder> pending = null;
        pending = tagManager.loadContainerPreferNonDefault(containerId, R("raw.defaultcontainer_binary"));

        // The onResult method will be called as soon as one of the following
        // happens:
        // 1. a saved container is loaded
        // 2. if there is no saved container, a network container is loaded
        // 3. the 2-second timeout occurs
        pending.setResultCallback(new ResultCallback<ContainerHolder>() {

            @Override
            public void onResult(ContainerHolder containerHolder) {
                Log.d(LCAT, "TagManager onResult : " + containerHolder.getStatus().getStatusMessage());

                ContainerHolderSingleton.setContainerHolder(containerHolder);

                Container container = containerHolder.getContainer();

                if (!containerHolder.getStatus().isSuccess()) {
                    Log.d(LCAT, "failure loading container");
                    return;
                }

                ContainerHolderSingleton.setContainerHolder(containerHolder);
                ContainerLoadedCallback.registerCallbacksForContainer(container);
            }

        }, TIMEOUT_FOR_CONTAINER_OPEN_MILLISECONDS, TimeUnit.MILLISECONDS);
    }

    private static class ContainerLoadedCallback implements ContainerHolder.ContainerAvailableListener {
        @Override
        public void onContainerAvailable(ContainerHolder containerHolder, String containerVersion) {
            // We load each container when it becomes available.
            Container container = containerHolder.getContainer();
            registerCallbacksForContainer(container);
        }

        public static void registerCallbacksForContainer(Container container) {
        }
    }
}
