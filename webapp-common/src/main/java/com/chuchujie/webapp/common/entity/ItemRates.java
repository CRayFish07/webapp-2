package com.chuchujie.webapp.common.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ItemRates  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3704818224360689234L;

	private Integer id;

    private Long itemId;

    private String skuValues;

    private Long rateId;

    private String nick;

    private String rateContent;

    private Date rateDate;

    private Byte platfrom;

    private Boolean hasImg;

    private Boolean status;

    private Integer parentId;

    private String rateImgs;
    
    List<RateStar>rateStars;

    public List<RateStar> getRateStars() {
		return rateStars;
	}

	public void setRateStars(List<RateStar> rateStars) {
		this.rateStars = rateStars;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getSkuValues() {
        return skuValues;
    }

    public void setSkuValues(String skuValues) {
        this.skuValues = skuValues == null ? null : skuValues.trim();
    }

    public Long getRateId() {
        return rateId;
    }

    public void setRateId(Long rateId) {
        this.rateId = rateId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public String getRateContent() {
        return rateContent;
    }

    public void setRateContent(String rateContent) {
        this.rateContent = rateContent == null ? null : rateContent.trim();
    }

    public Date getRateDate() {
        return rateDate;
    }

    public void setRateDate(Date rateDate) {
        this.rateDate = rateDate;
    }

    public Byte getPlatfrom() {
        return platfrom;
    }

    public void setPlatfrom(Byte platfrom) {
        this.platfrom = platfrom;
    }

    public Boolean getHasImg() {
        return hasImg;
    }

    public void setHasImg(Boolean hasImg) {
        this.hasImg = hasImg;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getRateImgs() {
        return rateImgs;
    }

    public void setRateImgs(String rateImgs) {
        this.rateImgs = rateImgs == null ? null : rateImgs.trim();
    }

	@Override
	public String toString() {
		return "ItemRates [id=" + id + ", itemId=" + itemId + ", skuValues="
				+ skuValues + ", rateId=" + rateId + ", nick=" + nick
				+ ", rateContent=" + rateContent + ", rateDate=" + rateDate
				+ ", platfrom=" + platfrom + ", hasImg=" + hasImg + ", status="
				+ status + ", parentId=" + parentId + ", rateImgs=" + rateImgs
				+ ", rateStars=" + rateStars + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hasImg == null) ? 0 : hasImg.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		result = prime * result + ((nick == null) ? 0 : nick.hashCode());
		result = prime * result
				+ ((parentId == null) ? 0 : parentId.hashCode());
		result = prime * result
				+ ((platfrom == null) ? 0 : platfrom.hashCode());
		result = prime * result
				+ ((rateContent == null) ? 0 : rateContent.hashCode());
		result = prime * result
				+ ((rateDate == null) ? 0 : rateDate.hashCode());
		result = prime * result + ((rateId == null) ? 0 : rateId.hashCode());
		result = prime * result
				+ ((rateImgs == null) ? 0 : rateImgs.hashCode());
		result = prime * result
				+ ((rateStars == null) ? 0 : rateStars.hashCode());
		result = prime * result
				+ ((skuValues == null) ? 0 : skuValues.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemRates other = (ItemRates) obj;
		if (hasImg == null) {
			if (other.hasImg != null)
				return false;
		} else if (!hasImg.equals(other.hasImg))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		if (nick == null) {
			if (other.nick != null)
				return false;
		} else if (!nick.equals(other.nick))
			return false;
		if (parentId == null) {
			if (other.parentId != null)
				return false;
		} else if (!parentId.equals(other.parentId))
			return false;
		if (platfrom == null) {
			if (other.platfrom != null)
				return false;
		} else if (!platfrom.equals(other.platfrom))
			return false;
		if (rateContent == null) {
			if (other.rateContent != null)
				return false;
		} else if (!rateContent.equals(other.rateContent))
			return false;
		if (rateDate == null) {
			if (other.rateDate != null)
				return false;
		} else if (!rateDate.equals(other.rateDate))
			return false;
		if (rateId == null) {
			if (other.rateId != null)
				return false;
		} else if (!rateId.equals(other.rateId))
			return false;
		if (rateImgs == null) {
			if (other.rateImgs != null)
				return false;
		} else if (!rateImgs.equals(other.rateImgs))
			return false;
		if (rateStars == null) {
			if (other.rateStars != null)
				return false;
		} else if (!rateStars.equals(other.rateStars))
			return false;
		if (skuValues == null) {
			if (other.skuValues != null)
				return false;
		} else if (!skuValues.equals(other.skuValues))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
    
}