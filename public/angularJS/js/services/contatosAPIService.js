//Criando um service com o factory
myApp.factory("contatosAPI", function($http, config) {
	var data = {};
	
	var _getContatos = function() {
		return $http.get(config.baseUrl + "/contatos");
	};

	var _saveContato = function(contato) {
		return $http.post(config.baseUrl + "/contato/save", contato);
	};
	
	var _getContato = function(id){
		return $http.get(config.baseUrl + "/contato/"+id);
	};
	
	var _delContato = function(id){
		return $http.post(config.baseUrl + "/contato/delete", id);
	}
	
	var _setData = function(contato){
		data.contato = contato;
	}
	
	var _getData = function(){
		return data;
	}
	
	var _editContato = function(contato){
		return $http.post(config.baseUrl + "/contato/edit", contato);
	}
	

	return {

		getContatos : _getContatos,
		saveContato : _saveContato,
		getContato  : _getContato,
		delContato	: _delContato,
		setData		: _setData,
		getData		: _getData,
		editContato : _editContato
	};
});
