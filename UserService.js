'user strict'; /* strictly follows the case i.e--case sensitive */

app.factory('UserService', [
		'$http',
		'$q',
		'$rootScope',
		function($http, $q, $rootScope) {
			console.log("User SERvices....//")
			var BASE_URL = 'http://localhost:8088/cobackend/'
			return {
				getAllUsers : function() {
					console.log(" calling fetch all Users..//")
					return $http.get(BASE_URL + '/usreL').then(
							function(response) {
								return response.data;
							}, null

					);
				},

				myProfile : function() {
					console.log("  Users.. profile..in user service//")
					return $http.get(BASE_URL + '/myProfile').then(
							function(response) {
								return response.data;
							}, null

					);
				},

				accept : function(id) {
					console.log("   calling approved.... in user service//")
					return $http.get(BASE_URL + '/accept/' + id).then(
							function(response) {
								return response.data;
							}, null

					);
				},

				reject : function(id, reasonn) {
					console.log("   calling reject....in user service//")
					return $http
							.get(BASE_URL + '/reject/' + id + '/' + reasonn)
							.then(function(response) {
								return response.data;
							}, null

							);
				},

				register : function(user) {
					console.log("   calling register....in user servive//")
					return $http.post(BASE_URL + '/register/', user).then(
							function(response) {
								return response.data;
							}, /*null*/
							function(errResponse){
								console.error('Error while creating User');
								return $q.reject(errResponse);
							}	

					);
				},

				updateUser : function(user) {
					console.log("   updating userr....in user service//")
					return $http.put(BASE_URL + '/update/', user).then(
							function(response) {
								return response.data;
							}, null

					);
				},

				logout : function(user) {
					console.log("   loggout userr....in user service//")
					return $http.put(BASE_URL + '/logout/', user).then(
							function(response) {
								return response.data;
							}, null

					);
				},

				authenticate : function(user) {
					console.log("   calling the authenticate userr....in user service//")
					return $http.post(BASE_URL + '/authenticate/', user).then(
							function(response) {
								return response.data;
							}, function(errResponse) {
								console.error('Error while logging out ..in user service');
								return $q.reject(errResponse);
							}

					);
				},

			}
		}
		
		]

);