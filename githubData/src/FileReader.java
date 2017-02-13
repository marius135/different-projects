import java.util.List;
import org.json.*;

public class FileReader implements GithubFileReader {

    String fileName;

    FileReader (String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<String> parseFiles() {



        JSONObject obj = new JSONObject(" .... ");
        String pageName = obj.getJSONObject("pageInfo").getString("pageName");

        JSONArray arr = obj.getJSONArray("posts");
        for (int i = 0; i < arr.length(); i++)
        {
            String post_id = arr.getJSONObject(i).getString("post_id");
        }
    }
}
