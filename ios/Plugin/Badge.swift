import Foundation
import Capacitor

@objc public class Badge: NSObject {
    private let storageKey = "capacitor.badge"
    private var defaults: UserDefaults {
        return UserDefaults.standard
    }
    
    override init() {
        super.init()
        restore()
    }
    
    @objc public func requestPermissions(completion: @escaping (_ granted: Bool, _ error: Error?) -> Void) {
        UNUserNotificationCenter.current().requestAuthorization(options: .badge) { granted, error in
            completion(granted, error)
        }
    }
    
    @objc public func checkPermissions(completion: @escaping (_ status: String) -> Void) {
        UNUserNotificationCenter.current().getNotificationSettings { settings in
            let permission: String

            switch settings.authorizationStatus {
            case .authorized, .ephemeral, .provisional:
                permission = "granted"
            case .denied:
                permission = "denied"
            case .notDetermined:
                permission = "prompt"
            @unknown default:
                permission = "prompt"
            }

            completion(permission)
        }
    }
    
    @objc public func get() -> Int {
        return defaults.integer(forKey: storageKey)
    }
    
    @objc public func set(count: Int, completion: @escaping () -> Void) {
        DispatchQueue.main.async { [weak self] in
            guard let strongSelf = self else {
                return
            }
            UIApplication.shared.applicationIconBadgeNumber = count
            strongSelf.defaults.set(count, forKey: strongSelf.storageKey)
            completion()
        }
    }
    
    @objc public func clear(completion: @escaping () -> Void) {
        set(count: 0, completion: completion)
    }
    
    @objc private func restore() {
        let count = get()
        set(count: count, completion: {})
    }
}
