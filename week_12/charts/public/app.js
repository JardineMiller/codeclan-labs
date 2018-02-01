var makeRequest = function(url, callback) {
  var request = new XMLHttpRequest();
  request.open('GET', url);
  request.addEventListener('load', callback);
  request.send();
}

var requestComplete = function() {
  if(this.status !== 200) return;
  var jsonString = this.responseText;
  var countries = JSON.parse(jsonString);
  getAllCountryData(countries);
}

var getCountryData = function(country) {
  return {
    name: country.name,
    y: country.population
  }
}

var getAllCountryData = function(countriesList) {
  chartData = countriesList.map(function(each) {
    return getCountryData(each);
  });
  createChart(chartData);
}

var createChart = function(countryData) {
  var container = document.querySelector('#pie-chart');
  new PieChart('Population of Countries', countryData);
}

var app = function() {
  var url = 'https://restcountries.eu/rest/v2/regionalbloc/nafta';
  var naftaButton = document.querySelector('#nafta-button');
  var euButton = document.querySelector('#eu-button');
  var carButton = document.querySelector('#caricom-button');

  naftaButton.addEventListener('click', function() {
    url = 'https://restcountries.eu/rest/v2/regionalbloc/nafta';
    makeRequest(url, requestComplete);
  })

  carButton.addEventListener('click', function() {
    url = 'https://restcountries.eu/rest/v2/regionalbloc/caricom';
    makeRequest(url, requestComplete);
  })

  euButton.addEventListener('click', function() {
    url = 'https://restcountries.eu/rest/v2/regionalbloc/eu';
    makeRequest(url, requestComplete);
  })

  makeRequest(url, requestComplete);
  // new PieChart();
  // new BarChart();
}

window.addEventListener('load', app);


