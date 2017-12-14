/*
 * Copyright (C) 2014 youten
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package comcesar1287.github.tagyou.controller.util;

import android.os.Environment;
import android.util.Log;

import java.util.List;

public class CsvDumpUtil {
    private static final String TAG = CsvDumpUtil.class.getSimpleName();
    private static final String HEADER = "DisplayName,MAC Addr,RSSI,Last Updated,iBeacon flag,Proximity UUID,major,minor,TxPower";
    private static final String DUMP_PATH = "/iBeaconDetector/";

    /**
     * dump scanned device list csv to external storage. Filename include now timestamp.
     * 
     * @param deviceList BLE scanned device list
     * @return csv file path. If Error, return null.
     */
    public static String dump(List<ScannedDevice> deviceList) {
        if ((deviceList == null) || (deviceList.size() == 0)) {
            return null;
        }
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + DUMP_PATH
                + DateUtil.get_nowCsvFilename();
        Log.d(TAG, "dump path=" + path);

        StringBuilder sb = new StringBuilder();
        sb.append(HEADER).append("\n");
        for (ScannedDevice device : deviceList) {
            sb.append(device.toCsv()).append("\n");
        }
//        try {
//            //FileUtils.write(new File(path), sb.toString(), HTTP.UTF_8);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }

        return path;
    }

    private CsvDumpUtil() {
        // util
    }
}
