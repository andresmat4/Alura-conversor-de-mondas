import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorJson {
    public void guardarJson(DatosDeMonedas datosDeMonedas) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter escritura = new FileWriter(datosDeMonedas.base_code()+".json");
        escritura.write(gson.toJson(datosDeMonedas));
        escritura.close();
    }
}
