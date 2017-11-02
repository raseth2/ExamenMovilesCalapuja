  <?PHP
/*
  $url = "http://www.upt.edu.pe";

  $html = file_get_contents($url);

  preg_match_all("/<img[\s]+[^>]*?src[\s]?=[\s\"\']+(.*\.([gif|jpg|png|bmp|jpeg|tiff]{3,4}))[\"\']+.*?>/", $html, $images);

  $images = $images[1];

  $list = array();

  foreach($images as $img) {

     echo $img."<br>";

  }*/
  //Especifica la dirección de un contenido, y conservar a $text 
function web(){
	$url = 'http://www.upt.edu.pe'; //subí tu ejemplo a pastebin

    //Obtener el texto de la página web
    $html = file_get_contents($url);
     $doc->loadHTML($html, LIBXML_COMPACT | LIBXML_HTML_NOIMPLIED | LIBXML_NONET);
     $textoejemplo = $doc->getElementsByClassName('overflow-hidden');
   
}

function obtener_titulo() {

$url = 'http://www.upt.edu.pe'; //subí tu ejemplo a pastebin

    //Obtener el texto de la página web
    $html = file_get_contents($url);

    //Generar el DOM
    $doc = new DOMDocument;
    $doc->loadHTML($html, LIBXML_COMPACT | LIBXML_HTML_NOIMPLIED | LIBXML_NONET);

    //Obtener el elemento por el id "textoejemplo"
    $textoejemplo = $doc->getElementById('home_noticia');

    //Obtener el texto del elemento
    $texto = $textoejemplo->textContent;

    //Imprimir el resultado
    echo "Texto: " . $texto;


}



function optener_imagen() {
	$text=file_get_contents('http://www.upt.edu.pe'); 

	preg_match('/<div[^>]*id="home_noticia"[^>]*>(.*?) <\/div>/si',$text,$match); 


	print($match[1]); 

}

print(obtener_titulo());
print(optener_imagen());

  ?>
