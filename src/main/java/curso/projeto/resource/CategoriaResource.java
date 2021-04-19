package curso.projeto.resource;

import curso.projeto.model.Categoria;
import curso.projeto.repository.CategoriaRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/categoria")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    @Inject
    private CategoriaRepository categoriaRepository;

    @GET
    @Path("/listar-todas")
    public List<Categoria> listarCategorias(){

        return categoriaRepository.listAll();
    }

    @POST
    @Path("/salvar")
    @Transactional
    public Categoria salvarCategoria(@Valid Categoria categoria){
        categoria.persist(categoria);
        return categoria;
    }

}
