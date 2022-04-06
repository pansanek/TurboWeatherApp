package com.example.weatherapptutorial;

import org.json.JSONException;
import org.json.JSONObject;

public class weatherData {

    private String mTemperature,micon,mcity,mWeatherType,mBack;
    private int mCondition;

    public static weatherData fromJson(JSONObject jsonObject)
    {

        try
        {
            weatherData weatherD=new weatherData();
            weatherD.mcity=jsonObject.getString("name");
            weatherD.mCondition=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mWeatherType=jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherD.micon=updateWeatherIcon(weatherD.mCondition);
            weatherD.mBack=updateBackground(weatherD.mCondition);
            double tempResult=jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue=(int)Math.rint(tempResult);
            weatherD.mTemperature=Integer.toString(roundedValue);
            return weatherD;
        }


         catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }


    private static String updateWeatherIcon(int condition)
    {
        if(condition>=0 && condition<=300)
        {
            return "thunderstrom1";
        }
        else if(condition>=300 && condition<=500)
        {
            return "lightrain";
        }
        else if(condition>=500 && condition<=600)
        {
            return "shower";
        }
       else  if(condition>=600 && condition<=700)
        {
            return "snow1";
        }
        else if(condition>=701 && condition<=771)
        {
            return "fog";
        }

        else if(condition>=772 && condition<800)
        {
            return "overcast";
        }
       else if(condition==800)
        {
            return "sunny";
        }
        else if(condition>=801 && condition<=804)
        {
            return "cloudy";
        }
       else  if(condition>=900 && condition<=902)
        {
            return "thunderstrom1";
        }
        if(condition==903)
        {
            return "snow1";
        }
        if(condition==904)
        {
            return "sunny";
        }
        if(condition>=905 && condition<=1000)
        {
            return "thunderstrom1";
        }

        return "Sorry :(";


    }
    private static String updateBackground(int condition)
    {
        if(condition>=0 && condition<=300)//thunder
        {
            return "background_dark";
        }
        else if(condition>=300 && condition<=500)//lightrain
        {
            return "background_darkgrey";
        }
        else if(condition>=500 && condition<=600)//rain
        {
            return "background_darkdarkgrey";
        }
        else  if(condition>=600 && condition<=700)//snow
        {
            return "background_darklight";
        }
        else if(condition>=701 && condition<=771) //fog
        {
            return "background_grey";
        }

        else if(condition>=772 && condition<800)//overcast
        {
            return "background_darkgrey";
        }
        else if(condition==800)//sunny
        {
            return "background_light";
        }
        else if(condition>=801 && condition<=804)//cloudy
        {
            return "background_darkgrey";
        }
        else  if(condition>=900 && condition<=902)//thunder
        {
            return "background_darkdarkgrey";
        }
        if(condition==903) //snow
        {
            return "background_darklight";
        }
        if(condition==904)//sunny
        {
            return "background_light";
        }
        if(condition>=905 && condition<=1000)//thunder
        {
            return "background_darkdarkgrey";
        }

        return "Sorry :(";


    }
    public String getmTemperature() {
        return mTemperature+"°C";
    }

    public String getMicon() {
        return micon;
    }

    public String getMcity() {
        return mcity;
    }

    public String getMback() {
        return mBack;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }
}
