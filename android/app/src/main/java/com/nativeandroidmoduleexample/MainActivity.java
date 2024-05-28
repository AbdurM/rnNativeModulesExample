package com.nativeandroidmoduleexample;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactActivityDelegate;
import com.facebook.react.ReactActivity;
import com.liveperson.infra.CampaignInfo;
import com.liveperson.infra.ConversationViewParams;
import com.liveperson.infra.ICallback;
import com.liveperson.infra.InitLivePersonProperties;
import com.liveperson.infra.LPConversationsHistoryStateToDisplay;
import com.liveperson.infra.auth.LPAuthenticationType;
import com.liveperson.infra.callbacks.InitLivePersonCallBack;
import com.liveperson.infra.callbacks.PKCEParamsCallBack;
import com.liveperson.infra.model.LPWelcomeMessage;
import com.liveperson.infra.model.MessageOption;
import com.liveperson.infra.model.PKCEParams;
import com.liveperson.infra.model.errors.PkceGenerateError;
import com.liveperson.messaging.sdk.api.LPConfig;
import com.liveperson.messaging.sdk.api.LivePerson;
import com.liveperson.messaging.sdk.api.model.ConsumerProfile;
import com.liveperson.infra.InitLivePersonProperties;
import com.liveperson.infra.MonitoringInitParams;
import com.liveperson.infra.auth.LPAuthenticationParams;
public class MainActivity extends ReactActivity {
  private static final String APP_ID = "com.nativeandroidmoduleexample";
  private static MainActivity instance;


  public static MainActivity getInstance() {
    return instance;
  }

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "nativeAndroidModuleExample";
  }

  /**
   * Returns the instance of the {@link ReactActivityDelegate}. Here we use a util class {@link
   * DefaultReactActivityDelegate} which allows you to easily enable Fabric and Concurrent React
   * (aka React 18) with two boolean flags.
   */
  @Override
  protected ReactActivityDelegate createReactActivityDelegate() {
    instance = this;
    return new DefaultReactActivityDelegate(
        this,
        getMainComponentName(),
        // If you opted-in for the New Architecture, we enable the Fabric Renderer.
        DefaultNewArchitectureEntryPoint.getFabricEnabled());
  }
  public void initLp() {
    // LivePerson.Logging.setSDKLoggingLevel(LogLevel.DEBUG);
    String brandID = "XXXXXX";
    String appInstallID = "XXXXXXX";
    final MonitoringInitParams monitoringInitParams = new MonitoringInitParams(appInstallID);
    LivePerson.initialize(this, new InitLivePersonProperties(brandID, APP_ID, monitoringInitParams, new InitLivePersonCallBack() {
      @Override
      public void onInitSucceed() {
        LPAuthenticationParams lpAuthenticationParams = new LPAuthenticationParams(LPAuthenticationType.UN_AUTH);
        LivePerson.showConversation(MainActivity.this, lpAuthenticationParams, new ConversationViewParams());
      }

      @Override
      public void onInitFailed(Exception e) {
      }
    }));

  }
}
