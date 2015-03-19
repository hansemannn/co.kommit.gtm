/**
 * gtm-ios
 *
 * Created by Your Name
 * Copyright (c) 2015 Your Company. All rights reserved.
 */


#import "CoKommitGtmModule.h"
#import "TiBase.h"
#import "TiHost.h"
#import "TiUtils.h"
#import "TAGContainer.h"
#import "TAGContainerOpener.h"
#import "TAGLogger.h"
#import "TAGManager.h"

@interface CoKommitGtmModule ()<TAGContainerOpenerNotifier>
@end

@implementation CoKommitGtmModule

// TAGContainerOpenerNotifier callback.
- (void)containerAvailable:(TAGContainer *)container {
    // Note that containerAvailable may be called on any thread, so you may need to dispatch back to
    // your main thread.
    dispatch_async(dispatch_get_main_queue(), ^{
        self.container = container;
        NSLog(@"[INFO] containerAvailable");
    });
}


#pragma mark Internal


// this is generated for your module, please do not change it
-(id)moduleGUID
{
	return @"f7683663-3883-47fc-a475-50db054013b2";
}

// this is generated for your module, please do not change it
-(NSString*)moduleId
{
	return @"co.kommit.gtm";
}

#pragma mark Lifecycle

-(void)startup
{
	// this method is called when the module is first loaded
	// you *must* call the superclass
	[super startup];

	NSLog(@"[INFO] %@ loaded",self);
}

-(void)shutdown:(id)sender
{
	// this method is called when the module is being unloaded
	// typically this is during shutdown. make sure you don't do too
	// much processing here or the app will be quit forceably

	// you *must* call the superclass
	[super shutdown:sender];
}

#pragma mark Cleanup

-(void)dealloc
{
	// release any resources that have been retained by the module
	[super dealloc];
}

#pragma mark Internal Memory Management

-(void)didReceiveMemoryWarning:(NSNotification*)notification
{
	// optionally release any resources that can be dynamically
	// reloaded once memory is available - such as caches
	[super didReceiveMemoryWarning:notification];
}

#pragma mark Listener Notifications

-(void)_listenerAdded:(NSString *)type count:(int)count
{
	if (count == 1 && [type isEqualToString:@"my_event"])
	{
		// the first (of potentially many) listener is being added
		// for event named 'my_event'
	}
}

-(void)_listenerRemoved:(NSString *)type count:(int)count
{
	if (count == 0 && [type isEqualToString:@"my_event"])
	{
		// the last listener called for event named 'my_event' has
		// been removed, we can optionally clean up any resources
		// since no body is listening at this point for that event
	}
}

#pragma Public APIs

-(void)init: (id)args
{
	ENSURE_ARG_COUNT(args, 1);
	NSString *containerId = [TiUtils stringValue:[args objectAtIndex:0]];
	NSLog(@"[init] %@ ", containerId);

    self.tagManager = [TAGManager instance];

    [self.tagManager.logger setLogLevel:kTAGLoggerLogLevelVerbose];

    [TAGContainerOpener openContainerWithId:containerId
                                 tagManager:self.tagManager
                                   openType:kTAGOpenTypePreferFresh
                                    timeout:nil
                                   notifier:self];
}

-(NSString*)getString: (id)args
{
	ENSURE_ARG_COUNT(args, 1);
	NSString *key = [TiUtils stringValue:[args objectAtIndex:0]];
	NSLog(@"[getString] %@ ", key);

	return key;
}

-(NSNumber*)getBoolean: (id)args
{
	ENSURE_ARG_COUNT(args, 1);
	NSString *key = [TiUtils stringValue:[args objectAtIndex:0]];
	NSLog(@"[getString] %@ ", key);

	return NUMBOOL(1);
}

-(NSNumber*)getLong: (id)args
{
	ENSURE_ARG_COUNT(args, 1);
	NSString *key = [TiUtils stringValue:[args objectAtIndex:0]];
	NSLog(@"[getLong] %@ ", key);

	return NUMINT(1);
}

-(NSNumber*)getDouble: (id)args
{
	ENSURE_ARG_COUNT(args, 1);
	NSString *key = [TiUtils stringValue:[args objectAtIndex:0]];
	NSLog(@"[getLong] %@ ", key);

	return NUMDOUBLE(1.0);
}

-(NSNumber*)getLastRefreshtTime: (id)args
{

	return NUMINT(1);
}

-(void)pushObject: (id)args
{
	ENSURE_SINGLE_ARG(args,NSDictionary);

    TAGDataLayer *dataLayer = [TAGManager instance].dataLayer;
    [dataLayer push:args];

	NSLog(@"[pushObject] %@ ", args);
}


-(void)pushValue: (id)args
{
	NSLog(@"[pushValue] %@ ", args);
}

@end
