package edu.escuelaing.arem.designprimer;
import static spark.Spark.*;
public class SparkWebApp {

    public static void main(String[] args){
        port(getPort());
        staticFiles.location("/public");
        get("/hello",(req, res) -> "Hello Heroku");
        get("/intraday", (req, res) -> {
            res.type("application/json");
            return HttpConnectionExample.getAPIAdvantageIntraDay();
        });

    }
    static int getPort(){
        if(System.getenv("PORT")!= null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
