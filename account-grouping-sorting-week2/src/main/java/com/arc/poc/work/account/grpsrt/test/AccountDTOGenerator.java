package com.arc.poc.work.account.grpsrt.test;

import java.util.ArrayList;
import java.util.List;

import com.arc.datamodel.dto.DBAccountDTO;

public class AccountDTOGenerator {

	
	public static List<DBAccountDTO> dummyDBAccountDTOs() {
		List<DBAccountDTO> list = new ArrayList<>();
		list.add(dummyDBAccountDTO("CHK", 5, false));
		list.add(dummyDBAccountDTO("CHK", 5, false));
		list.add(dummyDBAccountDTO("CHK", 5, false));
		list.add(dummyDBAccountDTO("ACK", 5, false));
		list.add(dummyDBAccountDTO("ICK", 5, false));
		list.add(dummyDBAccountDTO("ICK", 5, false));
		list.add(dummyDBAccountDTO("SAV1", 5, false));
		list.add(dummyDBAccountDTO("SAV2", 5, false));
		list.add(dummyDBAccountDTO("SAV1", 5, false));
		list.add(dummyDBAccountDTO("SAV2", 5, false));
		list.add(dummyDBAccountDTO("MOL", 2, false));
		list.add(dummyDBAccountDTO("MOL", 2, false));
		list.add(dummyDBAccountDTO("CCM", 2, false));
		list.add(dummyDBAccountDTO("CCL", 2, false));
		list.add(dummyDBAccountDTO("CCL", 2, false));
		list.add(dummyDBAccountDTO("BRK", 4, false));
		list.add(dummyDBAccountDTO("BRK", 4, false));
		list.add(dummyDBAccountDTO("610", 3, false));
		list.add(dummyDBAccountDTO("666", 3, false));
		list.add(dummyDBAccountDTO("MUT", 3, false));
		list.add(dummyDBAccountDTO("EXT", null, true));
		return list;
	}
	
	public static DBAccountDTO dummyDBAccountDTO(final String type, final Integer source, final boolean isExt) {
		DBAccountDTO dbAccountDTO = new DBAccountDTO();
		dbAccountDTO.setAccountDetailType(type);
		dbAccountDTO.setDataSource(source);
		dbAccountDTO.setExternal(isExt);
		return dbAccountDTO;
	}
	
}
