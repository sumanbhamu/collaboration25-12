var app1 = angular.module('myApp', ['ngRoute']);

app1.config(function($routeProvider) {
	  $routeProvider

		
		
		 .when('/', {
			    templateUrl : 'c_about/first.html'
			   
			  })

			  .when('/about', {
			    templateUrl : 'c_about/about.html'
			   
			  })

			  .when('/contact', {
			    templateUrl : 'c_about/contact.html'
			   
			  })

			  .otherwise({redirectTo: '/'});
});
