angular.module("locale_form",[])
    .controller("AppCtrl", function ($scope, $http) {
        $scope.auth = {};
        $scope.messageEng = function(auth){
            $http({
                method: "POST",
                url: "/eng",
                data: $.param(auth),
                headers: { "Content-Type" : "application/x-www-form-urlencoded" }
            }).then(
                function(data) {
                    window.alert("eng");
                    $scope.users = data.data.users;
                },
                function(error) {
                    window.alert("Доступ запрещен");
                }
            );
        }
        $scope.messageUkr = function(auth){
            $http({
                method: "POST",
                url: "/ukr",
                data: $.param(auth),
                headers: { "Content-Type" : "application/x-www-form-urlencoded" }
            }).then(
                function(data) {
                    window.alert("ukr");
                    $scope.users = data.data.users;
                },
                function(error) {
                    window.alert("Доступ запрещен");
                }
            );
        }
    });

    btn_ukr = document.querySelector('.btn_ukr'),
    btn_eng = document.querySelector('.btn_eng'),
    ukr_data = document.getElementById('ukr_data'),
    end_data = document.getElementById('end_data');

btn_ukr.addEventListener('click', function(){
    ukr_data.style.display = 'table-cell';
    end_data.style.display = 'none';
});
btn_eng.addEventListener('click', function(){
    end_data.style.display = 'table-cell';
    ukr_data.style.display = 'none';
});