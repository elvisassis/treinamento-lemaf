myApp.factory("loadingInterceptor", function($q, $rootScope, $timeout){
	//interceptos loading..
	return{
		request: function(config){
			$rootScope.loading = true;
			return config;
		},
		requestErro: function(rejection){
			$rootScope.loading = false;
			return $q.rejection(rejection);
		},
		response: function(response){
			$timeout(function(){
				$rootScope.loading = false;	
			},300);
			return response;
		},
		responseErro: function(rejection){
			$rootScope.loading = false;
			return $q.rejection(rejection);
		}
	};
});
