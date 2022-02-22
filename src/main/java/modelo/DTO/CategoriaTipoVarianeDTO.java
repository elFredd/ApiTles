package modelo.DTO;

import modelo.db.CategoriaTipoVariane;

/**
 * @created 08/12/2021 - 09:22 p. m.
 * @project ApiTles
 * @autor alfre
 */
public class CategoriaTipoVarianeDTO {
    private int idCategoriaTipo;
    private Integer status;
    private CategoriaDTO categoriaByIdCategoria;
    private TipoVarianteDTO tipoVarianteByIdTipoVariante;

    public CategoriaTipoVarianeDTO(CategoriaTipoVariane categoriaTipoVariane){
        this.idCategoriaTipo= categoriaTipoVariane.getIdCategoriaTipo();
        this.status=categoriaTipoVariane.getStatus();
        this.categoriaByIdCategoria=new CategoriaDTO(categoriaTipoVariane.getCategoriaByIdCategoria());
        this.tipoVarianteByIdTipoVariante=new TipoVarianteDTO(categoriaTipoVariane.getTipoVarianteByIdTipoVariante());
    }


    public int getIdCategoriaTipo() {
        return idCategoriaTipo;
    }

    public void setIdCategoriaTipo(int idCategoriaTipo) {
        this.idCategoriaTipo = idCategoriaTipo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public CategoriaDTO getCategoriaByIdCategoria() {
        return categoriaByIdCategoria;
    }

    public void setCategoriaByIdCategoria(CategoriaDTO categoriaByIdCategoria) {
        this.categoriaByIdCategoria = categoriaByIdCategoria;
    }

    public TipoVarianteDTO getTipoVarianteByIdTipoVariante() {
        return tipoVarianteByIdTipoVariante;
    }

    public void setTipoVarianteByIdTipoVariante(TipoVarianteDTO tipoVarianteByIdTipoVariante) {
        this.tipoVarianteByIdTipoVariante = tipoVarianteByIdTipoVariante;
    }
}
