var PieChart = function(title, data) {
  var container = document.querySelector('#pie-chart');
  var chart = new Highcharts.Chart({
    chart: {
      type: 'pie',
      renderTo: container
    },
    title: {
      text: title
    },
    series: [{
      name: 'Count',
      data: data
    }]
  });
}