import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(BadgePlugin)
public class BadgePlugin: CAPPlugin {
    private let implementation = Badge()
    
    @objc override public func requestPermissions(_ call: CAPPluginCall) {
        implementation.requestPermissions(completion: { granted, error in
            guard error == nil else {
                call.reject(error!.localizedDescription)
                return
            }
            call.resolve(["display": granted ? "granted" : "denied"])
        })
    }

    @objc override public func checkPermissions(_ call: CAPPluginCall) {
        implementation.checkPermissions(completion: { permission in
            call.resolve([
                "display": permission
            ])
        })
    }

    @objc func get(_ call: CAPPluginCall) {
        let count = implementation.get()
        call.resolve([
            "count": count
        ])
    }
    
    @objc func set(_ call: CAPPluginCall) {
        implementation.requestPermissions(completion: { [weak self] granted, error in
            guard let strongSelf = self else {
                return
            }
            guard error == nil else {
                call.reject(error!.localizedDescription)
                return
            }
            let count = call.getInt("count") ?? 0
            strongSelf.implementation.set(count: count, completion: {
                call.resolve()
            })
        })
    }
    
    @objc func increase(_ call: CAPPluginCall) {
        implementation.requestPermissions(completion: { [weak self] granted, error in
            guard let strongSelf = self else {
                return
            }
            guard error == nil else {
                call.reject(error!.localizedDescription)
                return
            }
            strongSelf.implementation.increase(completion: {
                call.resolve()
            })
        })
    }
    
    @objc func decrease(_ call: CAPPluginCall) {
        implementation.requestPermissions(completion: { [weak self] granted, error in
            guard let strongSelf = self else {
                return
            }
            guard error == nil else {
                call.reject(error!.localizedDescription)
                return
            }
            strongSelf.implementation.decrease(completion: {
                call.resolve()
            })
        })
    }
    
    @objc func clear(_ call: CAPPluginCall) {
        implementation.requestPermissions(completion: { [weak self] granted, error in
            guard let strongSelf = self else {
                return
            }
            guard error == nil else {
                call.reject(error!.localizedDescription)
                return
            }
            strongSelf.implementation.clear(completion: {
                call.resolve()
            })
        })
    }
}
