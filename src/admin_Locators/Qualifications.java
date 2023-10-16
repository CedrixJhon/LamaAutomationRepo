package admin_Locators;

public class Qualifications {
	public static final String click_admin = "//a[contains(text(),'Admin')]";
	public static final String click_qualificationsDropdown = "//a[contains(text(),'Qualifications')]";
	public static final String click_newQualificationsButton = "//button[contains(text(),'New Qualification')]";
	
	
	public static final String click_typeDropdown = "#mat-select-value-1";
	
	//Select 'Training' in Type Dropdown
	public static final String click_type_Training = "#mat-option-1";
	
	//select 'Experience in Type Dropdown
	public static final String click_type_Experience = "//body[1]/div[3]/div[4]/div[1]/div[1]/div[1]/mat-option[4]/span[1]";
	
	//click type dropdown for verify and update
	public static final String click_updateType = "/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-qualifications/div/form/div[1]/div/div/app-dropdown/div/div[2]/div/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]";

	
	public static final String verify_typeDropDownInput = "//*[@id=\"mat-select-value-3\"]";
	public static final String verifyAndUpdate_typeDropDownInput = "/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-qualifications/div/form/div[1]/div/div/app-dropdown/div/div[2]/div/mat-form-field/div/div[1]/div[3]/mat-select/div/div[1]";
	
	public static final String qualificationsField = "//input[contains(@step,'null')]";
	public static final String descriptionField = "//textarea[contains(@ngmodelchanged,'onValueChanged($event)')]";
	public static final String saveButton = "//body/div[3]/div[2]/div[1]/mat-dialog-container[1]/app-add-qualifications[1]/div[1]/form[1]/div[2]/div[1]/button[2]";

	
	public static final String click_updateIcon = "//*[@id=\"table-container\"]/table/tbody/tr[1]/td[5]/span/span/mat-icon";
	public static final String close = "//body/div[3]/div[2]/div[1]/mat-dialog-container[1]/app-add-qualifications[1]/div[1]/div[1]/h5[1]/img[1]";
	
	public static final String click_deleteIcon = "/html/body/app-root/app-admin-panel/section/div/div/div/admin-qualifications/div/div/div[2]/section/admin-reusable-list-view/section/div[2]/div/table/tbody/tr[1]/td[5]/span/span/img";
	public static final String click_continueButton = "/html/body/div[3]/div[2]/div/mat-dialog-container/app-delete-record/div[2]/div/div/button[2]";
	
}
