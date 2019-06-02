import java.util.ArrayList;
import java.util.List;

import edu.uci.ics.perpetual.acquisition.AcquisitionManager;
import edu.uci.ics.perpetual.acquisition.datatypes.AcquisitionFunction;
import edu.uci.ics.perpetual.acquisition.datatypes.DataSource;
import edu.uci.ics.perpetual.acquisition.datatypes.DataSourceType;
import edu.uci.ics.perpetual.acquisition.datatypes.RawType;
import edu.uci.ics.perpetual.acquisition.datatypes.Request;
import edu.uci.ics.perpetual.acquisition.datatypes.RequestStatus;
import edu.uci.ics.perpetual.acquisition.requestmanagement.AcquisitionRequestManager;

public class TestMain {

	public static void main(String[] args) throws Exception {
		AcquisitionRequestManager arq = AcquisitionManager.getInstance().getRequestManager();
		Request request = new Request(); 
		request.setReqId(1);
		AcquisitionFunction acFunct = new AcquisitionFunction();
		acFunct.setName("TemperatureProducer");
		acFunct.setParams("{}");
		DataSourceType forType = new DataSourceType();
		RawType rawType = new RawType();
		rawType.setId(1);
		rawType.setName("Image");
		forType.setRawType(rawType);
		forType.setDsTypeId(1);
		forType.setDsTypeName("WifiObservation");
		forType.setDsTypeParams("{}");
		acFunct.setForType(forType);
		acFunct.setPath("C:\\Users\\shamalip\\Documents\\Reads\\IOT datamanagement\\workspace\\appWorkspace\\TempProducer\\target\\temparatureAcquisition-1.0-SNAPSHOT.jar");
		acFunct.setParams("{\"filePath\":\"C:/Users/shamalip/Documents/Reads/IOT datamanagement/workspace\"}");
		request.setAcquisitionFunction(acFunct);
		request.setStartTime(System.currentTimeMillis() + 100);
		request.setEndTime(System.currentTimeMillis() + 10000);
		request.setResolution(3);
		List<DataSource> dataSources = new ArrayList<DataSource>();
		DataSource dataSourceA = new DataSource();
		dataSourceA.setDsInstanceId(123);
		dataSourceA.setDsInstanceName("HT_Sensor_dataset");
		dataSourceA.setDsName("WifiObservation");
		dataSourceA.setDsParams("{\"ip\":\"localhost\",\"port\":\"1243\"}");
		dataSourceA.setType(forType);
		dataSources.add(dataSourceA);
		/*DataSource dataSourceB = new DataSource();
		dataSourceA.setDsInstanceId(435);
		dataSourceA.setDsInstanceName("WifiObservationICS");
		dataSourceA.setDsName("WifiObservation");
		dataSourceA.setDsParams("{\"ip\":\"localhost\",\"port\":\"3456\"}");
		dataSourceA.setType(forType);
		dataSources.add(dataSourceB);*/
		request.setDataSources(dataSources);
		request.setStatus(RequestStatus.NEW);
		arq.addRequest(request);
		
	}
}
