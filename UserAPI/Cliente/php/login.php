<?php

$dbHost = "localhost";
$dbUser = "root";
$dbPass = "";
$dbName = "usuarios";

$conexion = pg_connect($dbHost,$dbUser,$dbPass,$dbName);

if(!$conexion){
    die("No hay conexión").pg_connect_error();
}

$nombre = $_POST["correo"];
$contraseña = $_POST["contraseña"];

$query = pg_query($conexion,"SELECT * FROM usuarios WHERE usuario = '".$nombre."' and contraseña = '".$contraseña."'");
$nrFilas = pg_num_rows($query);


if($nrFilas == 1){
    header("location: /html/pagUsuario.html");
}
else{
    header("location: /html/indexIncio.html");
    echo "<script>alert('Correo o contraseña incorrecto');</script>";
}
?>