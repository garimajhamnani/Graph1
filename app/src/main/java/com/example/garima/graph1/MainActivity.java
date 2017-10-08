package com.example.garima.graph1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;




public class MainActivity extends AppCompatActivity {
    private LineGraphSeries<DataPoint> series, series2;
    private final int maxData = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        series = new LineGraphSeries<>();
        series2 = new LineGraphSeries<>();
        series.appendData(new DataPoint(0, 0), true, maxData);
        series2.appendData(new DataPoint(0, 0), true, maxData);
        series2.setColor(Color.RED);
        series2.setThickness(1);
        GraphView graph = (GraphView)findViewById(R.id.graph);
        graph.addSeries(series);
        graph.addSeries(series2);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(maxData);
        for (int i=0;i<maxData;i++)
        { series.appendData(new DataPoint(i, i), true, maxData);
            series2.appendData(new DataPoint(i,2*i), true, maxData);

        }
    }
}


