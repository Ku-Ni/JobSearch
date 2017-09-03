package co.uk.coenie.integration.jobsites.config;

public class Constants {
	public enum JobSite {
		REED("www.reed.co.uk");
		
		private String url;
		
		JobSite(String url){
			this.url = url;
		}
		
		public String url() {
	        return url;
	    }
	}
	
	public enum SalaryType {
		HOURLY, DAILY, WEEKLY, MONTHLY, ANNUALLY;
	}
	
	public enum ContractType {
		PERMANENT, CONTRACT, TEMPORARY;
	}
	
	public enum JobType {
		FULLTIME, PARTTIME;
	}
}
