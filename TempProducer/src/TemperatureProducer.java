import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import edu.uci.ics.perpetual.acquisition.datatypes.DataSource;
import edu.uci.ics.perpetual.acquisition.datatypes.Producer;
import edu.uci.ics.perpetual.acquisition.datatypes.Request;

public class TemperatureProducer extends Producer{

	private static final String COMMA_DELIMITER = ",";


	public TemperatureProducer(Request request, DataSource source) {
		super(request, source);
	}

	@Override
	public void fetch() throws IOException{
		BufferedReader br = null;
		try {
			Map<String,Object> params = getMapFromJSON(request.getAcquisitionFunction().getParams());
			String tempFilePath = (String) params.get("filePath");
			br = new BufferedReader(new FileReader(tempFilePath+"\\"+source.getDsInstanceName()+".csv"));
			String line;
			int idx = 0;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(COMMA_DELIMITER);
				sendMessage(idx, values);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(null != br) {
				br.close();
			}
		}
	}

}
