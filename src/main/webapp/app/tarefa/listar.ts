$scope.allNoticias = {};
 
$scope.listarNoticias = function(){
 $http.get('/desafio/tarefa/listar')
       .success(function(data){
              $scope.allNoticias = data;
       })
       .error(function(){
              alert("Falha em obter as tarefas");
       });
};