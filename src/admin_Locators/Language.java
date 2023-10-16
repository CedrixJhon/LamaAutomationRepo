package admin_Locators;

public class Language {
	public static final String click_admin = "//a[contains(text(),'Admin')]";
	public static final String click_languagDropdown = "//a[contains(text(),'Languages')]";
	public static final String click_newLanguageButton = "//button[contains(text(),'New Language')]";
	public static final String name_Field = "/html/body/div[3]/div[2]/div/mat-dialog-container/app-add-language/div/form/div[1]/app-textfield[1]/div/div[2]/div/input";
	public static final String code_Field = "//app-textfield[@label='Code']//input[@type='text']";
	public static final String click_saveButton = "//span[@class='mat-button-wrapper']//span[@class='ng-star-inserted'][normalize-space()='Add']";
	
	public static final String update_Icon = "//*[@id=\"table-container\"]/table/tbody/tr[1]/td[5]/span/span/mat-icon";
	public static final String close = "//body/div[3]/div[2]/div[1]/mat-dialog-container[1]/app-add-language[1]/div[1]/div[1]/h5[1]/img[1]";
	public static final String deleteButton = "/html/body/app-root/app-admin-panel/section/div/div/div/admin-languages/div/div/div[2]/section/admin-reusable-list-view/section/div[2]/div/table/tbody/tr[1]/td[5]/span/span/img";
	public static final String click_DeleteButton = "//span[contains(text(),'Continue')]";
	
	public static final String saveButton_Update = "//*[@id=\"mat-dialog-2\"]/app-add-language/div/form/div[2]/div/button[2]";
}
