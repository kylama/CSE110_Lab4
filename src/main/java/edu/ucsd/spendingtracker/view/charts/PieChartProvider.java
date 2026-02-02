package edu.ucsd.spendingtracker.view.charts;

import java.util.Map;

import edu.ucsd.spendingtracker.model.Category;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class PieChartProvider implements IChartProvider {
    @Override
    public Node createChart(Map<Category, Double> data) {
        PieChart chart = new PieChart();

        data.forEach((cat, sum) -> {
            chart.getData().add(new PieChart.Data(cat.name(), sum));
        });

        // XYChart.Series<String, Number> series = new XYChart.Series<>();

        // PieChart.Data series = new PieChart.Data(data);

        // chart.getData().add(data);

        for (PieChart.Data entry : chart.getData()) {
            String color = Category.valueOf(entry.getName()).color;
            Node slice = entry.getNode();
            if (slice != null) {
                slice.setStyle("-fx-pie-color: " + color + ";");
            }
        }

        chart.setLegendVisible(false);
        return chart;
    }

    @Override
    public String getDisplayName() {
        return "Pie Chart";
    }
}
