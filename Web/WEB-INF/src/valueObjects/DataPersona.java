package valueObjects;

public class DataPersona
{
    private String nombre;
    private String procedencia;

    public DataPersona()
    {
    }

    public DataPersona(String nombre, String procedencia)
    {
        this.nombre = nombre;
        this.procedencia = procedencia;
    }
    
    public String getNombre()
    {
        return nombre;
    }

    public String getProcedencia()
    {
        return procedencia;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public void setProcedencia(String procedencia)
    {
        this.procedencia = procedencia;
    }
}
