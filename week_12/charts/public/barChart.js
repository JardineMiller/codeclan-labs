var BarChart = function() {
  var container = document.querySelector('#bar-chart');
  var data = {
    chart: {
      type: 'column',
      renderTo: container
    },
    title: {
      text: 'Our Favourite Programming Languages'
    },
    series: [{
      name: 'Cohort 17',
      data: [8, 12, 3, 1],
      color: 'red'
    },
    {
      name: 'Cohort Lame',
      data:[19, 1, 2, 1],
      color: 'blue'
    },
    {
      name: 'Another Cohort Lame',
      data:[2, 5, 7, 5],
      color: 'green'
    }],
    xAxis: {
      categories: ['JavaScript', 'Java', 'Ruby', 'Python']
    }
  }
  var chart = new Highcharts.Chart(data)
}