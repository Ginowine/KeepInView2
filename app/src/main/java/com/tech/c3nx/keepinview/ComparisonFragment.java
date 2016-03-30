package com.tech.c3nx.keepinview;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ComparisonFragment extends Fragment {

    View rootView;
    WebView web;
    ProgressBar progressBar;

    public ComparisonFragment() {
        // Required empty public constructor
    }

    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();

        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        if (haveNetworkConnection()){
            rootView = inflater.inflate(R.layout.fragment_comparison, container, false);
            web = (WebView) rootView.findViewById(R.id.webView);
            progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
            //web.setWebViewClient(new myWebClient());
            web.setWebChromeClient(new WebChromeClient() {
                public void onProgressChanged(WebView view, int progress) {
                    if (progress < 100 && progressBar.getVisibility() == ProgressBar.GONE) {
                        progressBar.setVisibility(ProgressBar.VISIBLE);
                    }
                    progressBar.setProgress(progress);
                    if (progress == 100) {
                        progressBar.setVisibility(ProgressBar.GONE);
                    }
                }
            });
            web.setWebViewClient(new WebViewClient() {
                @Override
                public void onReceivedError(WebView view, int errorCode,
                                            String description, String failingUrl) {
                    // Handle the error

                    web.loadUrl("file:///android_res/drawable/splash.png");

                    Toast.makeText(getActivity(), "Oh no! Can't fetch data from Internet! Please Check your Connectivity", Toast.LENGTH_SHORT).show();
                }

                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            });
            web.getSettings().setJavaScriptEnabled(true);
            //web.getSettings().setBuiltInZoomControls(true);
            web.getSettings().setSupportZoom(true);
            //web.setInitialScale(1);
            web.getSettings().setLoadWithOverviewMode(true);
            //web.getSettings().setUseWideViewPort(false);
            web.loadUrl("https://www.google.com/fusiontables/embedviz?containerId=googft-gviz-canvas&q=select+col4%2C+col1%2C+col0+from+1BsgQmXy2VqGhuTMcp5ls07CamZJLBe0obEt1bIN3+order+by+col4+desc+limit+1&viz=GVIZ&t=COLUMN&uiversion=2&gco_forceIFrame=true&gco_hasLabelsColumn=true&gco_vAxes=%5B%7B%22title%22%3A%22Billions+(NGN)%22%2C+%22minValue%22%3Anull%2C+%22maxValue%22%3Anull%2C+%22useFormatFromData%22%3Afalse%2C+%22viewWindow%22%3A%7B%22max%22%3Anull%2C+%22min%22%3Anull%7D%2C+%22titleTextStyle%22%3A%7B%22color%22%3A%22%23222%22%2C+%22fontSize%22%3A%2214%22%2C+%22italic%22%3Atrue%2C+%22bold%22%3Atrue%7D%2C+%22textStyle%22%3A%7B%22color%22%3A%22%23222%22%2C+%22fontSize%22%3A12%2C+%22bold%22%3Afalse%2C+%22italic%22%3Atrue%7D%2C+%22logScale%22%3Afalse%2C+%22gridlines%22%3A%7B%22count%22%3A%22-1%22%7D%2C+%22minorGridlines%22%3A%7B%22count%22%3A%220%22%7D%2C+%22formatOptions%22%3A%7B%22source%22%3A%22inline%22%2C+%22prefix%22%3A%22%22%2C+%22suffix%22%3A%22%22%2C+%22scaleFactor%22%3A%221000000000%22%7D%2C+%22format%22%3A%220.%23%23%22%7D%2C%7B%22useFormatFromData%22%3Atrue%2C+%22viewWindow%22%3A%7B%22max%22%3Anull%2C+%22min%22%3Anull%7D%2C+%22minValue%22%3Anull%2C+%22maxValue%22%3Anull%2C+%22logScale%22%3Afalse%7D%5D&gco_useFirstColumnAsDomain=true&gco_isStacked=false&gco_booleanRole=certainty&gco_hAxis=%7B%22useFormatFromData%22%3Atrue%2C+%22minValue%22%3Anull%2C+%22maxValue%22%3Anull%2C+%22viewWindow%22%3Anull%2C+%22viewWindowMode%22%3Anull%2C+%22title%22%3A%22%22%2C+%22textStyle%22%3A%7B%22color%22%3A%22%23ff0000%22%2C+%22fontSize%22%3A%2215%22%2C+%22bold%22%3Atrue%2C+%22italic%22%3Atrue%7D%2C+%22titleTextStyle%22%3A%7B%22color%22%3A%22%23222%22%2C+%22fontSize%22%3A%2214%22%2C+%22italic%22%3Atrue%2C+%22bold%22%3Atrue%7D%7D&gco_legend=top&gco_title=Nigerian+2016+Budget+Comparison&gco_titleTextStyle=%7B%22color%22%3A%22%23000%22%2C+%22fontSize%22%3A%2218%22%2C+%22bold%22%3Atrue%2C+%22italic%22%3Afalse%7D&gco_fontName=Verdana&gco_series=%7B%220%22%3A%7B%22color%22%3A%22%23274e13%22%2C+%22targetAxisIndex%22%3A0%7D%2C+%221%22%3A%7B%22targetAxisIndex%22%3A0%7D%7D&gco_backgroundColor=%7B%22fill%22%3A%22%23ffe599%22%7D&gco_domainAxis=%7B%22direction%22%3A1%7D&gco_focusTarget=category&width=500&height=300");
        }else {
            rootView = inflater.inflate(R.layout.fragment_comparison_error, container, false);
            Toast.makeText(getActivity(), "Oh no! Can't fetch data from Internet! Please Check your Connectivity", Toast.LENGTH_SHORT).show();
        }
        return rootView;

    }

}
