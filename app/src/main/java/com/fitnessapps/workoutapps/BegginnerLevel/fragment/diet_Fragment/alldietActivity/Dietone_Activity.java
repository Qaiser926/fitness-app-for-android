package com.fitnessapps.workoutapps.BegginnerLevel.fragment.diet_Fragment.alldietActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.diet_Fragment.DayOneDietFragment.BeforebedDiet;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.diet_Fragment.DayOneDietFragment.BreakfastDiet;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.diet_Fragment.DayOneDietFragment.DinnertimeDiet;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.diet_Fragment.DayOneDietFragment.EmptyStomachDiet;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.diet_Fragment.DayOneDietFragment.EveningTimeDiet;
import com.fitnessapps.workoutapps.BegginnerLevel.fragment.diet_Fragment.DayOneDietFragment.LunchTimeDiet;
import com.fitnessapps.workoutapps.R;

public class Dietone_Activity extends AppCompatActivity {

    InterstitialAd fbinterstitialads;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietone_);

        EmptyStomach();
        BreakFast();
        Lunchtime();
        Eveningtime();
        Dinnertime();
        Beforebedtime();
        fbInterstitial_ads();
        com.facebook.ads.AdView adView = new com.facebook.ads.AdView(this, getResources().getString(R.string.fb_bannner_ads), AdSize.BANNER_HEIGHT_50);
// Find the Ad Container
        LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);
// Add the ad view to your activity layout
        adContainer.addView(adView);
// Request an ad
        adView.loadAd();
    }

    private void Beforebedtime() {
        BeforebedDiet beforebedDiet=new BeforebedDiet();
        getSupportFragmentManager().beginTransaction().add(R.id.beforeBed_container,beforebedDiet).commit();
    }

    private void Dinnertime() {
        DinnertimeDiet dinnertimeDiet=new DinnertimeDiet();
        getSupportFragmentManager().beginTransaction().add(R.id.dinner_container,dinnertimeDiet).commit();
    }

    private void Eveningtime() {
        EveningTimeDiet eveningTimeDiet=new EveningTimeDiet();
        getSupportFragmentManager().beginTransaction().add(R.id.evening_container,eveningTimeDiet).commit();
    }

    private void Lunchtime() {
        LunchTimeDiet lunchTimeDiet=new LunchTimeDiet();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.lunch_container,lunchTimeDiet)
                .commit();
    }

    // ye code me ne activity me fragment add kia , is liye ye code lika he
    private void BreakFast() {
        BreakfastDiet breakfastDiet=new BreakfastDiet();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.breakfast_container, breakfastDiet)
                .commit();
    }
    private void EmptyStomach() {

        EmptyStomachDiet emptyStomachDiet=new EmptyStomachDiet();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.emptystomach_container,emptyStomachDiet)
                .commit();

    }
    private void fbInterstitial_ads(){
        AudienceNetworkAds.initialize(this);
        fbinterstitialads = new InterstitialAd(this, getResources().getString(R.string.fb_interstitial_ads));
        // Create listeners for the Interstitial Ad
        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                // Show the ad
                fbinterstitialads.show();
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback

            }
        };

        // For auto play video ads, it's recommended to load the ad
        // at least 30 seconds before it is shown
        fbinterstitialads.loadAd(
                fbinterstitialads.buildLoadAdConfig()
                        .withAdListener(interstitialAdListener)
                        .build());
    }
    @Override
    protected void onDestroy() {
        if (fbinterstitialads != null) {
            fbinterstitialads.destroy();
        }
        super.onDestroy();
    }

}