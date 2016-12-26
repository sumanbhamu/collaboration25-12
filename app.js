
var app = angular.module('myApp', ['ngRoute']);

app.config(function($routeProvider) {
  $routeProvider

  .when('/', {
    templateUrl : 'c_about/home.html',
   
   
  })

  .when('/blog', {
    templateUrl : 'c_about/blog.html',
    
   
  })

  .when('/friend', {
    templateUrl : 'c_about/friend.html',
    
  })
  
   .when('/job', {
    templateUrl : 'c_about/job.html',
    
   
  })

  .otherwise({redirectTo: '/'});
});

