//
//  ContentView.swift
//  Umamee
//
//  Created by Adrian Vergara on 9/21/19.
//  Copyright © 2019 Adrian Vergara. All rights reserved.
//

import SwiftUI

struct ContentView: View {
    @State private var selection = 0
 
    var body: some View {
        TabView(selection: $selection){
            Text("Welcome to Your Cookbook")
                .font(.title)
                .tabItem {
                    VStack {
                        Image("first")
                        Text("My Cookbook")
                    }
                }
                .tag(0)
            Text("Second View")
                .font(.title)
                .tabItem {
                    VStack {
                        Image("second")
                        Text("Second")
                    }
                }
                .tag(1)
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
