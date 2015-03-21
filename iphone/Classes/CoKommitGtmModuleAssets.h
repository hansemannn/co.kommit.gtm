/**
 * Google Tag Manager Titanium Module
 *
 * Created by Cristian Cepeda <cristian.cepeda@kommit.co>
 * Copyright (c) 2015 Kommit.co. All rights reserved.
 */

@interface CoKommitGtmModuleAssets : NSObject
{
}
- (NSData*) moduleAsset;
- (NSData*) resolveModuleAsset:(NSString*)path;

@end
