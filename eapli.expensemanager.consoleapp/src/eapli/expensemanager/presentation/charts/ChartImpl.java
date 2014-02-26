/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.presentation.charts;

import eapli.expensemanager.model.ExpenseType;
import eapli.expensemanager.model.report.AggregatedExpenses;
import eapli.expensemanager.model.report.ExpensesReport;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.event.WindowEvent;
import java.util.Map.Entry;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * 
 * @author nuno
 */
public class ChartImpl extends ApplicationFrame implements Chart {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFreeChart chart = null;
	private String domainAxisLabel = "Default domainAxisLabel";
	private String rangeAxisLabel = "Default rangeAxisLabel";
	private String windowTitle = "Default Window Title";
	private String chartTitle = "Default Graph Title";
	private CategoryDataset chartDataset = null;

		public ChartImpl(String windowTitle) {
			super(windowTitle);
			if (windowTitle != null && windowTitle.length() == 0) {
				this.windowTitle = windowTitle;
			}
			super.setTitle(this.windowTitle);
		}

	/**
	 * Tenho de efetuar o override ao evento windowClosing, caso contrário o
	 * fecho da janela do gráfico finaliza a aplicação
	 */
		@Override
	public void windowClosing(WindowEvent event) {
		// System.out.println("Window Closing");
		dispose();
		// não se pode invocar o pai, caso contrário invoca o System.exit
		// super.windowClosing(event);
	}

	public void setDomainAxisLabel(String domainAxisLabel) {
		this.domainAxisLabel = domainAxisLabel;
	}

	public void setRangeAxisLabel(String rangeAxisLabel) {
		this.rangeAxisLabel = rangeAxisLabel;
	}

	@Override
	public void setWindowTitle(String windowTitle) {
		this.windowTitle = windowTitle;
		super.setTitle(this.windowTitle);
	}

	@Override
	public void setChartTitle(String chartTitle) {
		this.chartTitle = chartTitle;
	}

	@Override
	public void setDataset(ExpensesReport expenseReport) {

		// Apenas vou utilizar uma série
		// row keys...
		String series1 = "Expenses";
		// String series2 = "Second";
		// String series3 = "Third";

		// create the dataset...
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (Entry<ExpenseType, AggregatedExpenses> entry : expenseReport
				.getAggregatedExpensesPerType().entrySet()) {
			// System.out.println("Expenses for type:" +
			// entry.getKey().getDescription());
			dataset.addValue(entry.getValue().getSum(), series1, entry.getKey()
					.getDescription());
		}

		chartDataset = dataset;
		// column keys...
		/*
		 * String category1 = "Category 1"; String category2 = "Category 2";
		 * String category3 = "Category 3"; String category4 = "Category 4";
		 * String category5 = "Category 5";
		 * 
		 * dataset.addValue(1.0, series1, category1); dataset.addValue(4.0,
		 * series1, category2); dataset.addValue(3.0, series1, category3);
		 * dataset.addValue(5.0, series1, category4); dataset.addValue(5.0,
		 * series1, category5);
		 * 
		 * /*dataset.addValue(5.0, series2, category1); dataset.addValue(7.0,
		 * series2, category2); dataset.addValue(6.0, series2, category3);
		 * dataset.addValue(8.0, series2, category4); dataset.addValue(4.0,
		 * series2, category5);
		 * 
		 * dataset.addValue(4.0, series3, category1); dataset.addValue(3.0,
		 * series3, category2); dataset.addValue(2.0, series3, category3);
		 * dataset.addValue(3.0, series3, category4); dataset.addValue(6.0,
		 * series3, category5);
		 */

		// return dataset;
	}

	@Override
	public void doShow() {
		// criar o gráfico com o dataset
		chart = createChart(chartDataset);

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setFillZoomRectangle(true);
		chartPanel.setMouseWheelEnabled(true);
		chartPanel.setPreferredSize(new Dimension(500, 270));
		setContentPane(chartPanel);

		pack();
		RefineryUtilities.centerFrameOnScreen(this);
		setVisible(true);
	}

	/**
	 * Creates a sample chart.
	 * 
	 * @param dataset
	 *            the dataset.
	 * 
	 * @return The chart.
	 */
	private JFreeChart createChart(CategoryDataset dataset) {

		// create the chart...
		chart = ChartFactory.createBarChart(chartTitle, // chart title
				domainAxisLabel, // domain axis label
				rangeAxisLabel, // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
				true, // tooltips?
				false // URLs?
				);

		// NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

		// set the background color for the chart...
		chart.setBackgroundPaint(Color.white);

		// get a reference to the plot for further customisation...
		CategoryPlot plot = (CategoryPlot) chart.getPlot();

		// ******************************************************************
		// More than 150 demo applications are included with the JFreeChart
		// Developer Guide...for more information, see:
		//
		// > http://www.object-refinery.com/jfreechart/guide.html
		//
		// ******************************************************************

		// set the range axis to display integers only...
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		// disable bar outlines...
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setDrawBarOutline(false);

		// set up gradient paints for series...
		GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f,
				0.0f, new Color(0, 0, 64));

		// GradientPaint gp1 = new GradientPaint(0.0f, 0.0f, Color.green,
		// 0.0f, 0.0f, new Color(0, 64, 0));

		// GradientPaint gp2 = new GradientPaint(0.0f, 0.0f, Color.red,
		// 0.0f, 0.0f, new Color(64, 0, 0));

		renderer.setSeriesPaint(0, gp0);
		// renderer.setSeriesPaint(1, gp1);
		// renderer.setSeriesPaint(2, gp2);

		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions
				.createUpRotationLabelPositions(Math.PI / 6.0));
		// OPTIONAL CUSTOMISATION COMPLETED.

		return chart;
	}

	/**
	 * @return the chartDataset
	 */
	public CategoryDataset getChartDataset() {
		return chartDataset;
	}
	//
	// public static void main(String[] args) {
	//
	// ChartImpl demo = new ChartImpl("title");
	//
	// Map<ExpenseType, BigDecimal> mapExpenses = new HashMap<ExpenseType,
	// BigDecimal>();
	//
	// ExpenseType expenseTypeClothing = new ExpenseType("clothing",
	// "Clothing");
	// ExpenseType expenseTypeTransport = new ExpenseType("transport",
	// "Transport");
	//
	// BigDecimal expenseTypeClothingSum = new BigDecimal(12.3);
	// BigDecimal expenseTypeTransportSum = new BigDecimal(30);
	//
	// mapExpenses.put(expenseTypeClothing, expenseTypeClothingSum);
	// mapExpenses.put(expenseTypeTransport, expenseTypeTransportSum);
	//
	// //criar o dataSet a utilizar no gráfico
	// demo.setDataset(mapExpenses);
	//
	// demo.doShow();
	//
	// }
}