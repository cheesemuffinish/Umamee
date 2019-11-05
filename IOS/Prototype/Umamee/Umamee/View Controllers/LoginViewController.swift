//
//  LoginViewController.swift
//  Umamee
//
//  Created by Derek Thompson on 11/3/19.
//  Copyright © 2019 Derek Thompson. All rights reserved.
//

import UIKit
import FirebaseAuth

class LoginViewController: UIViewController {

    
    @IBOutlet weak var emailTextField: UITextField!
    
    @IBOutlet weak var passwordTextField: UITextField!
    
    @IBOutlet weak var loginButton: UIButton!
    
    @IBOutlet weak var errorLabel: UILabel!
    
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
        
        setUpElements()
        
    }
    

    
    func setUpElements() {
        
        // Hide the error label
        errorLabel.alpha = 0
        
        // Styling the Elements
        
        Utilities.styleTextField(emailTextField)
        
        Utilities.styleTextField(passwordTextField)
        
        Utilities.styleFilledButton(loginButton)
        
        
    }
    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
    
    func validateFields() -> String? {
        
        // Check that all fields are filled in
        if emailTextField.text?.trimmingCharacters(in: .whitespacesAndNewlines) == "" ||
            passwordTextField.text?.trimmingCharacters(in: .whitespacesAndNewlines) == "" {
            
            return "Please fill in all fields"
        }
        
        // Check if password is secure
        let cleanedPassword = passwordTextField.text!.trimmingCharacters(in: .whitespacesAndNewlines)
        
        if Utilities.isPasswordValid(cleanedPassword) == false {
        // Password isn't secure enough
            
            return "Please ensure password is at least 8 characters, contains a number, and a special character"
        }
        
        return nil
    }
    
    

    @IBAction func loginTapped(_ sender: Any) {
        
        // NOT COMPLETE!!!! Validate Text Fields
        let error = validateFields()
        
        if error != nil{
            // There was an error within the fields
            // Display error message
           showError(error!)
        }
        else {
        
        
            // Create cleaned versions of the text field
            let email = emailTextField.text!.trimmingCharacters(in: .whitespacesAndNewlines)
        
            let password = passwordTextField.text!.trimmingCharacters(in: .whitespacesAndNewlines)
        
            // Signing in the user
            Auth.auth().signIn(withEmail: email, password: password) { (result, error) in
            
                if error != nil {
                    // Couldn't login
                    self.errorLabel.text = error!.localizedDescription
                    self.errorLabel.alpha = 1
                }
                else{
                    self.transitiontoHome()
                
                
                }
            }
    
        }
        
    }
    
    func showError(_ message:String) {
        
        errorLabel.text = message
        errorLabel.alpha = 1
    }
    
    func transitiontoHome() {
        let homeViewController = storyboard?.instantiateViewController(identifier: Constants.Storyboard.homeViewController) as? HomeViewController
        
        view.window?.rootViewController = homeViewController
        view.window?.makeKeyAndVisible()
    }
    
}
