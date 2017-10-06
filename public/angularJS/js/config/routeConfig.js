myApp.config(function ($routeProvider){
	$routeProvider
		.when("/contatos",{
			templateUrl: "/public/angularJS/view/contatos.html",
			controller: "listaTelefonicaCtrl",
			resolve: {
				contatos: function(contatosAPI){
					return contatosAPI.getContatos()
				},
				operadoras: function (operadorasAPI){
					return operadorasAPI.getOperadoras();
				}
			}
			
		})
		.when("/",{
			templateUrl: "/public/angularJS/view/home.html"
		})
		.when("/error",{
			templateUrl: "public/angularJS/view/error.html"
			
		})
		.when("/novoContato",{
			templateUrl: "public/angularJS/view/novoContato.html",
			controller: "novoContatoCtrl",
			resolve: {
				operadoras: function (operadorasAPI){
					return operadorasAPI.getOperadoras();
				}
				
			}
		})
		.when("/editContato",{
			templateUrl: "public/angularJS/view/editContato.html",
			controller:  "editContatoCtrl",
			resolve: {
				contato: function (contatosAPI){
					return contatosAPI.getData();
				},
				operadoras: function (operadorasAPI){
					return operadorasAPI.getOperadoras();
				}
			}
		})
		
});



