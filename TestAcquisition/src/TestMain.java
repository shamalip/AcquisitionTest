import java.util.HashMap;

import edu.uci.ics.perpetual.acquisition.AcquisitionManager;
import edu.uci.ics.perpetual.acquisition.datatypes.AcquisitionRequest;
import edu.uci.ics.perpetual.acquisition.datatypes.RequestStatus;
import edu.uci.ics.perpetual.acquisition.requestmanagement.AcquisitionRequestManager;

public class TestMain {

	public static void main(String[] args) throws Exception {
		AcquisitionRequestManager arq = AcquisitionManager.getInstance().getRequestManager();
		AcquisitionRequest request = new AcquisitionRequest();
		request.setRequestId(22);
		request.setAcquisitionName("TemperatureProducer");
		HashMap<String, String> acquisitionFunctionParameters = new HashMap<>();
		acquisitionFunctionParameters.put("startTime", (System.currentTimeMillis() + 1000) + "");
		acquisitionFunctionParameters.put("endTime", (System.currentTimeMillis() + 7000) + "");
		acquisitionFunctionParameters.put("resolution", ""+3);
		acquisitionFunctionParameters.put("filePath", args[0]);
		request.setAcquisitionFunctionParameters(acquisitionFunctionParameters);
		request.setAcquisitionFunctionPath(args[1]);
		request.setDataSourceId(33);
		request.setStatus(RequestStatus.NEW);
		arq.addRequest(request);
		
	}
}
