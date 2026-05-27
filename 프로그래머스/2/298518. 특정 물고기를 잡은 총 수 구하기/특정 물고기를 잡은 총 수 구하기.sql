select count(*)
from FISH_INFO f
left join FISH_NAME_INFO n on f.FISH_TYPE = n.FISH_TYPE
where n.FISH_NAME = "BASS" or n.FISH_NAME = "SNAPPER";