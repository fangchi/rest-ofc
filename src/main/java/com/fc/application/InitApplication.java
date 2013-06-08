package com.fc.application;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import com.fc.resource.AreaChartResource;
import com.fc.resource.AreaHollowChartResource;
import com.fc.resource.AreaLineDashChartResource;
import com.fc.resource.Bar3DChartResource;
import com.fc.resource.BarAllClickChartResource;
import com.fc.resource.BarChartResource;
import com.fc.resource.BarGlassChartResource;
import com.fc.resource.CandleChartResource;
import com.fc.resource.FilledBarChartResource;
import com.fc.resource.HBarChartResource;
import com.fc.resource.HorizontalBarChartResource;
import com.fc.resource.LineChartResource;
import com.fc.resource.LineChartResourceReload;
import com.fc.resource.PieChartResource;
import com.fc.resource.RadarAreaChartResource;
import com.fc.resource.RadarChartResource;
import com.fc.resource.SaveImgResource;
import com.fc.resource.ScatterChartResource;
import com.fc.resource.SharpChartResource;
import com.fc.resource.SketchBarChartResource;

public class InitApplication extends Application{

	@Override    
    public Restlet createRoot() {     
        // Create a router Restlet that routes each call   
        //to a new instance of HelloWorldResource.     
        Router router = new Router(getContext());     
        // Defines only one route     
        router.attach("/AreaChartResource", AreaChartResource.class);   
        router.attach("/AreaHollowChartResource", AreaHollowChartResource.class);   
        router.attach("/AreaLineDashChartResource", AreaLineDashChartResource.class);   
        router.attach("/BarChartResource", BarChartResource.class); 
        router.attach("/Bar3DChartResource", Bar3DChartResource.class); 
        router.attach("/BarAllClickChartResource", BarAllClickChartResource.class); 
        router.attach("/BarGlassChartResource", BarGlassChartResource.class); 
        router.attach("/CandleChartResource", CandleChartResource.class); 
        router.attach("/FilledBarChartResource", FilledBarChartResource.class);  
        router.attach("/HorizontalBarChartResource", HorizontalBarChartResource.class);  
        router.attach("/HBarChartResource", HBarChartResource.class);  
        router.attach("/LineChartResource", LineChartResource.class); 
        router.attach("/LineChartResourceReload", LineChartResourceReload.class);  
        router.attach("/PieChartResource", PieChartResource.class);   
        router.attach("/RadarChartResource", RadarChartResource.class);
        router.attach("/RadarAreaChartResource", RadarAreaChartResource.class);
        router.attach("/ScatterChartResource", ScatterChartResource.class);  
        router.attach("/SharpChartResource", SharpChartResource.class);   
        router.attach("/SketchBarChartResource", SketchBarChartResource.class);   
        
        
        router.attach("/SaveImgResource", SaveImgResource.class);   
        return router;     
    }     
}
