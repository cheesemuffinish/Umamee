//
//  GroceryListViewController.swift
//  Umamee
//
//  Created by Derek Thompson on 11/4/19.
//  Copyright © 2019 Derek Thompson. All rights reserved.
//

import UIKit

class GroceryListViewController: UIViewController {

    @IBOutlet weak var browseRecipes: UIButton!
    
    @IBOutlet weak var myCookbook: UIButton!
    
    @IBOutlet weak var groceryList: UIButton!
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    

    /*
    // MARK: - Navigation

    // In a storyboard-based application, you will often want to do a little preparation before navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destination.
        // Pass the selected object to the new view controller.
    }
    */
    
    
    @IBAction func browseRecipesTapped(_ sender: Any) {
        self.transitiontoHome()
    }
    
    
    @IBAction func myCookbookTapped(_ sender: Any) {
        self.transitiontoCookbook()
    }
    
    @IBAction func groceryListTapped(_ sender: Any) {
        self.transitiontoGrocery()
    }
    
    func transitiontoHome() {
        let homeViewController = storyboard?.instantiateViewController(identifier: Constants.Storyboard.homeViewController) as? HomeViewController
        
        view.window?.rootViewController = homeViewController
        view.window?.makeKeyAndVisible()
    }
    
    func transitiontoCookbook() {
        let myCookbookViewController = storyboard?.instantiateViewController(identifier: Constants.Storyboard.myCookbookViewController) as? MyCookbookViewController
        
        view.window?.rootViewController = myCookbookViewController
        view.window?.makeKeyAndVisible()
    }
    
    func transitiontoGrocery() {
        let groceryListViewController = storyboard?.instantiateViewController(identifier: Constants.Storyboard.groceryListViewController) as? GroceryListViewController
        
        view.window?.rootViewController = groceryListViewController
        view.window?.makeKeyAndVisible()
    }

}
