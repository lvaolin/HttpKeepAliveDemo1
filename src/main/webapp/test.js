
function f() {
    var config = 1;
    alert(config);
    $(document).ready(function () {
        //请求参数信息
        while (true){
            alert("1222222");
            $.post("http://localhost:8080/http/servlet1",
                {
                    name: "Donald Duck",
                    city: "Duckburg"
                },
                function (data, status) {
                    alert("参数发生了变化: " + data + "\nStatus: " + status);
                    document.writeln(data)
                });
            //参数变化，变更界面上的参数值
            //继续请求参数信息
        }

    });
}

