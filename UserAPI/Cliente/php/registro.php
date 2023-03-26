<?php	

$dbHost = "localhost";
$dbUser = "root";
$dbPass = "";
$dbName = "usuarios";

$conexion = pg_connect($dbHost,$dbUser,$dbPass,$dbName);



if(!$conexion){
    die("No hay conexión").pg_connect_error();
}

$nombre = $_POST["userName"];
$contraseña = $_POST["contraseña"];

function validarRepetidos($usuario,$conexion){
    $query = pg_query($conexion,"SELECT * FROM usuario WHERE usuario='$usuario'");

    if(pg_num_rows($query) > 0){
        return 1;
    }else{
        return 0;
    }
}

if($nombre == null || $contraseña == null){
    header("location: /html/indexIncio.html");
    echo "<script>alert('Correo o contraseña incorrecto');</script>";
}else if(validarRepetidos($nombre, $conexion)>0){
    header("location: /html/indexIncio.html");
    echo "<script>alert('Correo o contraseña incorrecto');</script>";
}else{
    $query = mysqli_query($conexion,"INSERT INTO usuarios (usuario,contraseña) VALUES ('$nombre','$contraseña')");
    echo "<script>cambiarNombre($nombre);</script>";
    header("location: /html/pagUsuario.html");
}


?>