import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(BadgePlugin)
public class BadgePlugin: CAPPlugin {
    private let implementation = Badge()

    @objc func get(_ call: CAPPluginCall) {
        let count = implementation.get()
        call.resolve([
            "count": count
        ])
    }
    
    @objc func set(_ call: CAPPluginCall) {
        let count = call.getInt("count") ?? 0
        implementation.set(count: count, completion: {
            call.resolve()
        })
    }
    
    @objc func clear(_ call: CAPPluginCall) {
        implementation.clear(completion: {
            call.resolve()
        })
    }
}
