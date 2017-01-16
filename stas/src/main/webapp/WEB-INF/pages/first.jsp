<html>
<head>
 <title> first web page </title>
</head>

<body>
n1: <input type="text" id="n1" value=""/>
n2: <input type="text" id="n2" value=""/></br>
<input type="button" value="summ" onclick="sum()"/>

<input type="button" value="dynamic" onclick="generateFunction();"/>

<form id ="containerId">

</form>

<script type="text/javascript">
    function sum(){
        var n1 = document.getElementById("n1").value;
        var n2 = document.getElementById("n2").value;
        alert(parseInt(n1)+parseInt(n2));
    }

    function generateFunction(){
        var container = document.getElementById("containerId");

        var in1=document.createElement("input");
        in1.id="in1";
        in1.type="text";

        var in2=document.createElement("input");
        in2.id="in2";
        in2.type="text";

        var btn=document.createElement("input");
        btn.id="btn2";
        btn.type="button";
        btn.value="say hello";

        btn.onclick=function(){
            var n1=document.getElementById("in1").value;
            var n2=document.getElementById("in2").value;
            alert(parseInt(n1)+parseInt(n2));
        }


        container.append(in1);
        container.append(in2);
        container.append(btn);
    }
</script>

</body>

</html>