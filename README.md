# Aprendiendo a hacer una API REST con SpringBoot
## Anotaciones usadas:
- @RestController
    - para definir que es un controlador e indicar que es una API REST y tenga el patron MVC
- @GetMapping
    - para definir la ruta de la API y obtener un recurso
- @PostMapping
    - para definir la ruta de la API y crear un nuevo recurso
- @PutMapping
    - para definir la ruta de la API y actualizar un recurso
- @DeleteMapping
    - para definir la ruta de la API y eliminar un recurso
- @PathVariable
    - para definir y conectar un parametro en la ruta de la API con el metodo (path en la URL de la API)
- @RequestParam
    - para extraer un parametro de la URL de la API y pasarlo al metodo.
- @RequestBody
    - para definir la URL de la API base
- @ResponseStatus 
  - para definir el código de respuesta
- @RequestMapping 
  - para definir la ruta base de la API
- @HttpStatus
  - para definir el código de respuesta

Tambien use lo que es el ResponseEntity para devolver una respuesta 
personalizada con el codigo de respuesta y el cuerpo de la respuesta.