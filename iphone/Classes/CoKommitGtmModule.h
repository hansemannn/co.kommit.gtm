/**
 * gtm-ios
 *
 * Created by Your Name
 * Copyright (c) 2015 Your Company. All rights reserved.
 */

#import "TiModule.h"
#import "TiBase.h"
#import "TiHost.h"
#import "TiUtils.h"
#import "TAGContainer.h"
#import "TAGContainerOpener.h"
#import "TAGLogger.h"
#import "TAGManager.h"
#import "TAGDataLayer.h"

@class TAGManager;
@class TAGContainer;

@interface CoKommitGtmModule : TiModule{}

@property (nonatomic, retain) TAGManager *tagManager;
@property (nonatomic, retain) TAGContainer *tagContainer;

- (void) containerAvailable:(TAGContainer *)container;

@end
