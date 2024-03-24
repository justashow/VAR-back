package shootingstar.var.Service;

import shootingstar.var.dto.req.UserApplyVipDto;
import shootingstar.var.entity.VipApprovalType;
import shootingstar.var.entity.VipInfo;
import shootingstar.var.repository.Vip.VipInfoRepository;

public class BasicService {
    private static VipInfoRepository vipInfoRepository;
    public void applyVip(String userUUID , UserApplyVipDto userApplyVipDto){
        VipInfo vipInfo = VipInfo.builder()
                .vipInfoUUID(userUUID)
                .vipName(userApplyVipDto.getVipName())
                .vipJob(userApplyVipDto.getVipJob())
                .vipCareer(userApplyVipDto.getVipCareer())
                .vipIntroduce(userApplyVipDto.getVipIntroduce())
                .vipApprovalType(VipApprovalType.STANDBY)
                .vipEvidenceUrl(userApplyVipDto.getVipEvidenceUrl())
                .build();

        vipInfoRepository.save(vipInfo);
    }
}
