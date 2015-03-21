/**
 * Google Tag Manager Titanium Module
 *
 * Created by Cristian Cepeda <cristian.cepeda@kommit.co>
 * Copyright (c) 2015 Kommit.co. All rights reserved.
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

@interface CoKommitGtmModule : TiModule <TAGContainerOpenerNotifier> {}

@property (nonatomic, strong) TAGManager *tagManager;
@property (nonatomic, strong) TAGContainer *tagContainer;

- (void) containerAvailable:(TAGContainer *)container;
- (TAGDataLayer *) dataLayer;
@end
