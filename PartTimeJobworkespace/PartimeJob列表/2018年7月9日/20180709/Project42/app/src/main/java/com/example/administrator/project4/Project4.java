package com.example.administrator.project4;
        import android.content.Intent;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.os.StrictMode;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.ListView;
        import android.widget.Spinner;
        import android.widget.TableLayout;
        import android.widget.Toast;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.IOException;
        import java.io.InputStream;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.URL;
        import java.util.LinkedList;
        import android.widget.AdapterView.OnItemClickListener;


public class Project4 extends AppCompatActivity {
    private final int WC = ViewGroup.LayoutParams.MATCH_PARENT;
    private final int MP = ViewGroup.LayoutParams.MATCH_PARENT;
    private Button Button;
    ImageView imView;
    private TableLayout tableLayout;
    private ListView listview;
    private ProjectBaseApdater apdater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project4);
        final Spinner Spinner = (Spinner)findViewById(R.id.spinner);
        String[] list = new String[3];
        list[0]="musicTrack";
        list[1]="movie";
        list[2]="software";
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Project4.this, android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner.setAdapter(adapter);
        final EditText inputText = (EditText) findViewById(R.id.Search);

        Button = (Button) findViewById(R.id.button);
        Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String item = inputText.getText().toString();

                if( !(item.trim().equals("") || item.trim().length() < 2) ){//因为如果一个字母搜素容易出错
                    final String option = (String) Spinner.getSelectedItem();

                    String searchResult = HpptRequest.HpptRequest(item, option);

                    if (option.equalsIgnoreCase("musicTrack")) {
                        LinkedList<Music> music = new LinkedList<Music>();
                        try {
                            JSONArray jsonArray = new JSONArray(searchResult.substring(searchResult.indexOf("["), searchResult.lastIndexOf("]") + 1));
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String trackName = jsonObject.optString("trackName");
                                String artistName = jsonObject.optString("artistName");
                                Double trackPrice = jsonObject.optDouble("trackPrice");
                                Double collectionPrice = jsonObject.optDouble("collectionPrice");
                                String collectionName = jsonObject.optString("collectionName");
                                String artworkUrl30 = jsonObject.optString("artworkUrl30");
                                music.addLast(new Music(trackName, artistName, trackPrice, collectionPrice, collectionName, artworkUrl30));
                            }

                            if(jsonArray.length() != 0){
                                setListData(music);
                            }else{
                                Toast.makeText(Project4.this,"抱歉未找到以关键词搜索的信息",Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
//                        displayTableMusic(music.size()+1,3,music);
                    }else if(option.equalsIgnoreCase("movie")){
                        LinkedList<Movie> movie = new LinkedList<Movie>();
                        try {
                            JSONArray jsonArray = new JSONArray(searchResult.substring(searchResult.indexOf("["), searchResult.lastIndexOf("]") + 1));
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                String trackName = jsonObject.optString("trackName");
                                String contentAdvisoryRating = jsonObject.optString("contentAdvisoryRating");
                                Double trackHdPrice = jsonObject.optDouble("trackHdPrice");
                                String primaryGenreName = jsonObject.optString("primaryGenreName");
                                String longDescription = jsonObject.optString("longDescription");
                                String artworkUrl30 = jsonObject.optString("artworkUrl30");

                                movie.add(new Movie(trackName, longDescription, contentAdvisoryRating, trackHdPrice, primaryGenreName, artworkUrl30));
                            }
                            if(jsonArray.length() != 0){
                                setListData(movie);
                            }else{
                                Toast.makeText(Project4.this,"抱歉未找到以关键词搜索的信息",Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }else if(option.equalsIgnoreCase("software")){

                        LinkedList<SoftWare> software = new LinkedList<SoftWare>();
                        try {
                            JSONArray jsonArray = new JSONArray(searchResult.substring(searchResult.indexOf("["), searchResult.lastIndexOf("]") + 1));
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String artistName = jsonObject.optString("artistName");
                                Double price = jsonObject.optDouble("price");

                                JSONArray json2 = jsonObject.optJSONArray("supportedDevices");
                                String[] supportedDevices = new String[json2.length()];
                                for(int j = 0;j < json2.length(); j++){
                                    supportedDevices[j] = json2.getString(j);
                                }
                                String description = jsonObject.optString("description");

                                JSONArray json3 = jsonObject.optJSONArray("genres");
                                String[] genres = new String[json3.length()];
                                for(int j = 0;j < json3.length(); j++){
                                    genres[j] = json3.getString(j);
                                }

                                JSONArray json4 = jsonObject.optJSONArray("screenshotUrls");
                                String[] screenshotUrls = new String[json4.length()];
                                for(int j = 0;j < json4.length(); j++){
                                    screenshotUrls[j] = json4.getString(j);
                                }
                                software.add(new SoftWare(artistName, price, supportedDevices, description, genres, screenshotUrls));
                            }
                            if(jsonArray.length() != 0){
                                setListData(software);
                            }else{
                                Toast.makeText(Project4.this,"抱歉未找到以关键词搜索的信息",Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }else{

                    Toast.makeText(Project4.this,"请输入你要搜索的关键词并且至少两位关键字",Toast.LENGTH_SHORT).show();
                }
            }
        });
        findView();
    }
    public void findView(){
        listview = (ListView)this.findViewById(R.id.listviewlayout);
        apdater = new ProjectBaseApdater(this);
        //给item设置监听
        listview.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(position != 0){
                    Object ob =  ProjectBaseApdater.datalist.get(position);
                    moreInfo(ob);
                }else{
                    Toast.makeText(Project4.this,"您不能查询列名更多信息",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void moreInfo(Object ob){
        Music mu;
        Movie mv;
        SoftWare sw;
        Intent intent= new Intent(this,MoreInformation.class);
        if(ob instanceof  Music){
            mu = (Music)ob;
            intent.putExtra("mu", mu);

        }else if(ob instanceof  Movie){
            mv = (Movie)ob;
            intent.putExtra("mv", mv);
        }else if(ob instanceof SoftWare){
            sw = (SoftWare)ob;
            intent.putExtra("sw", sw);
        }
        startActivity(intent);
    }
    public void setListData(LinkedList data){
        //baseadapter
        if(data != null){
            apdater.setLinkListData(data);
            listview.setAdapter(apdater);
        }
    }

    private void displayTableMusic(int row, int col, final LinkedList<Music> list) {
    }

    public static Bitmap returnBitMap(String url) {
        URL myFileUrl = null;
        Bitmap bitmap = null;
        try {
            myFileUrl = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            HttpURLConnection conn = (HttpURLConnection) myFileUrl
                    .openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
