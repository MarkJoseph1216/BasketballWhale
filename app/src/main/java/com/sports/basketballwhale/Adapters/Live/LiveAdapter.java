package com.sports.basketballwhale.Adapters.Live;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import com.sports.basketballwhale.Model.Banners.Live;
import com.sports.basketballwhale.R;
import java.util.List;

public class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    public Context context;
    List<Live.Video> eventsArrayList;

    public LiveAdapter(Context context, List<Live.Video> eventsArrayList) {
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.eventsArrayList = eventsArrayList;
    }

    @Override
    public LiveAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.banners_live_item, parent, false);
        return new LiveAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LiveAdapter.ViewHolder holder, int position) {
        Live.Video video = eventsArrayList.get(position);

        loadWebViewURL(video.getEmbed(), holder.webViewLive);
        holder.txtLiveName.setText("Name: " + video.getTitle());
    }

    @Override
    public int getItemCount() {
        return eventsArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        WebView webViewLive;
        TextView txtLiveName;

        ViewHolder(View itemView) {
            super(itemView);

            webViewLive = itemView.findViewById(R.id.webViewLive);
            txtLiveName = itemView.findViewById(R.id.txtLiveName);
        }
    }

    private void loadWebViewURL(String url, WebView webView){
        webView.setVisibility(View.VISIBLE);
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.setWebViewClient(new WebViewClient()  {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
            @Override
            @TargetApi(Build.VERSION_CODES.N)
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                view.loadUrl(request.getUrl().toString());
                return true;
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);

            }
            @Override
            public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(context);
                String message = "SSL Certificate error.";
                switch (error.getPrimaryError()) {
                    case SslError.SSL_UNTRUSTED:
                        message = "The certificate authority is not trusted.";
                        break;
                    case SslError.SSL_EXPIRED:
                        message = "The certificate has expired.";
                        break;
                    case SslError.SSL_IDMISMATCH:
                        message = "The certificate Hostname mismatch.";
                        break;
                    case SslError.SSL_NOTYETVALID:
                        message = "The certificate is not yet valid.";
                        break;
                }
                message += " Do you want to continue anyway?";

                builder.setTitle("SSL Certificate Error");
                builder.setMessage(message);
                builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handler.proceed();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handler.cancel();
                    }
                });
                final AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadData(url, "text/html", "UTF-8");
    }
}